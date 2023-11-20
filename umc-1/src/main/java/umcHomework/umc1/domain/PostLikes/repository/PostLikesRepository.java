package umcHomework.umc1.domain.PostLikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcHomework.umc1.domain.PostLikes.entity.PostLikes;
import java.util.Optional;

public interface PostLikesRepository extends JpaRepository<PostLikes, Long> {
    Optional<PostLikes> findByMemberLikesAndPostLikes(Long memberId, Long postId);
}
