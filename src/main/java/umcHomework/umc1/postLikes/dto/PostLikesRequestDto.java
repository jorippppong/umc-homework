package umcHomework.umc1.postLikes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import umcHomework.umc1.member.entity.Member;
import umcHomework.umc1.post.entity.Post;

@Getter
@AllArgsConstructor
@Builder
public class PostLikesRequestDto {
    private Member member;
    private Post post;
}
