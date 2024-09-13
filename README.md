

:one:  Entitiy  -VO 

```java
@Getter //다른 사람이 이용하지 못하게 setter는 안되서 -> data는 못쓰고 getter만
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 -> 이곳에서 필요할때만 쓸수있게 proceted로 막아놈
public class Member {

  private Long memberId;
  private String email;
  private String password;

  @Builder
  public Member(String email, String password) {
    this.email = email;
    this.password = password;
  }
}

```

:two: Mapper  -DAO

데이터베이스와 애플리케이션 간의 데이터를 변환하는 역할을 하는 객체

데이터베이스에서 조회한 결과를 객체로 변환하거나, 객체를 데이터베이스에 저장할 때 사용 

Mapper에서는 Entity를 이용

```sql
@Mapper
public interface MemberMapper {

}

```

3️⃣ DTO - VO

1. request(요청)
    
    ```sql
    @Getter
    @AllArgsConstructor //모든 생성자
    @Builder
    public class MemberCreate {
    
      private Long email;
      private String password;
    
      public static MemberCreate of(Long email, String password) { //팩토리 메소드
        return MemberCreate.builder()
            .email(email)
            .password(password)
            .build();
      }
    }
    ```
    
2. response(응답)

4️⃣ Service

1. Service -선언
    
    ☑ DTO 이용 
    
    ```java
    //메소드 - 기능
    public interface MemberService {
    
      void createMember(MemberCreate memberCreate);
    }
    
    ```
    
2. ServiceImpl -구현
    
    ```java
    @Service
    public class MemberServiceImpl implements MemberService{
    
      @Override
      public void createMember(MemberCreate memberCreate) {
    
      }
    }
    
    ```
    

service interface를 상속받아 사용

5️⃣  Controller 

- service를 가져다 쓴다.
- spring은 의존성 주입을 해줘야 한다. `RequiredArgsConstructor`
    
    ```java
    import com.example.demo.member.dto.request.MemberCreate;
    import com.example.demo.member.service.MemberService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RequiredArgsConstructor //final로 된 애를 생성자로 만들어준다.
    @RestController
    @RequestMapping("/api/member")//공통적으로 만들어준다.
    public class MemberController {
    
      //스프링이 관리하도록 컨테이너에 등록해야한다...
      private final MemberService memberService;
      
      //api 연결 
      @PostMapping("/create")
      public ResponseEntity<?> createMember(@RequestBody MemberCreate request){
        memberService.createMember(request);
        return ResponseEntity.ok().body("성공");
      } 
    }
    
    ```
