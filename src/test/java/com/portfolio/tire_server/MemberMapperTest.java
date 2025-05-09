// package com.portfolio.tire_server;

// import com.portfolio.tire_server.mapper.MemberMapper;
// import com.portfolio.tire_server.model.MemberModel;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import java.util.List;

// import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// public class MemberMapperTest {

//     @Autowired
//     private MemberMapper memberMapper;

//     @Test
//     public void testFindAllMembers() {
//         List<MemberModel> members = memberMapper.findAllMembers();

//         assertThat(members).isNotNull();
//         assertThat(members).isNotEmpty();

//         members.forEach(m -> {
//             System.out.println("mb_no     : " + m.getMb_no());
//             System.out.println("name      : " + m.getName());
//             System.out.println("phone     : " + m.getPhone());
//             System.out.println("address   : " + m.getAddress());
//             System.out.println("id        : " + m.getId());
//             System.out.println("password  : " + m.getPassword());
//             System.out.println("-----------------------------");
//         });
//     }
// }
