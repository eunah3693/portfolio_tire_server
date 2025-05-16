function proxyImage(url) {
    // 프록시 서버 URL을 사용하여 이미지를 로드
    return `https://cors-anywhere.herokuapp.com/${url}`;
}

function loadImage(src) {
    return new Promise((resolve, reject) => {
        const img = new Image();
        img.crossOrigin = 'anonymous';
        img.onload = () => resolve(img);
        img.onerror = () => reject(new Error(`Failed to load image: ${src}`));
        img.src = src;
    });
}

function sanitizeImagesForCORS() {
    const promises = [];
    document.querySelectorAll('img').forEach(img => {
        const src = img.getAttribute('src');
        if (src && src.startsWith('http') && !src.includes(window.location.hostname)) {
            const proxySrc = proxyImage(src);
            promises.push(loadImage(proxySrc).then(() => {
                img.setAttribute('crossorigin', 'anonymous');
                img.src = proxySrc;
            }));
        }
    });
    return Promise.all(promises);
}

function captureAndShare(selector = '.estimate_preview_wrap') {
    const target = document.querySelector(selector);
    if (!target) {
        alert('선택한 요소를 찾을 수 없습니다.');
        return;
    }

    // 로딩 표시
    const loadingDiv = document.createElement('div');
    loadingDiv.style.position = 'fixed';
    loadingDiv.style.top = '50%';
    loadingDiv.style.left = '50%';
    loadingDiv.style.transform = 'translate(-50%, -50%)';
    loadingDiv.style.padding = '20px';
    loadingDiv.style.background = 'rgba(0, 0, 0, 0.7)';
    loadingDiv.style.color = 'white';
    loadingDiv.style.borderRadius = '5px';
    loadingDiv.style.zIndex = '9999';
    loadingDiv.textContent = '이미지 캡처 중...';
    document.body.appendChild(loadingDiv);

    sanitizeImagesForCORS()
        .then(() => {
            return html2canvas(target, {
                useCORS: true,
                allowTaint: true,
                logging: true,
                scale: window.devicePixelRatio,
                backgroundColor: '#ffffff'
            });
        })
        .then(canvas => {
            return new Promise((resolve, reject) => {
                canvas.toBlob(blob => {
                    if (blob) {
                        const file = new File([blob], 'capture.png', { type: 'image/png' });
                        resolve(file);
                    } else {
                        reject(new Error('Blob 생성 실패'));
                    }
                }, 'image/png');
            });
        })
        .then(file => {
            if (navigator.canShare && navigator.canShare({ files: [file] })) {
                return navigator.share({
                    title: '캡처 이미지',
                    text: '웹페이지 캡처 공유',
                    files: [file]
                });
            } else {
                // 공유 API를 지원하지 않는 경우 다운로드
                const link = document.createElement('a');
                link.href = URL.createObjectURL(file);
                link.download = 'capture.png';
                link.click();
                URL.revokeObjectURL(link.href);
                throw new Error('이 브라우저에서는 이미지 공유를 지원하지 않습니다.');
            }
        })
        .catch(err => {
            console.error('캡처/공유 실패:', err);
            if (err.message !== '이 브라우저에서는 이미지 공유를 지원하지 않습니다.') {
                alert('이미지 캡처 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
            }
        })
        .finally(() => {
            document.body.removeChild(loadingDiv);
        });
} 