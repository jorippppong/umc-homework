package umcHomework.umc1.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import umcHomework.umc1.domain.PostLikes.entity.PostLikes;
import umcHomework.umc1.domain.member.dto.MemberRequestDto;
import umcHomework.umc1.domain.post.entity.Post;


import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(name = "PHONE")
    private String phoneNum;

    @Column(name = "bday")
    private String bDay;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "memberLikes", cascade = CascadeType.ALL)
    private List<PostLikes> postLikes = new ArrayList<>();

    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void updateMember(MemberRequestDto memberRequestDto){
        if(memberRequestDto.getName() != null){
            this.name = memberRequestDto.getName();
        }
        if(memberRequestDto.getNickname() != null){
            this.nickname = memberRequestDto.getNickname();
        }
    }
}