package umcHomework.umc1.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umcHomework.umc1.domain.member.entity.Member;
import umcHomework.umc1.domain.post.entity.Post;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private Member member;

    public static PostResponseDto of(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .member(post.getMember())
                .build();
    }
}
