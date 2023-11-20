package umcHomework.umc1.domain.PostLikes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import umcHomework.umc1.domain.member.entity.Member;
import umcHomework.umc1.domain.post.entity.Post;

@Getter
@AllArgsConstructor
@Builder
public class PostLikesRequestDto {
    private Member member;
    private Post post;
}
