package umcHomework.umc1.domain.member.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
    @Id
    @Column(name = "RT_KEY")
    private String key;

    @Column(name = "RT_VALUE")
    private String value;

    public RefreshToken updateValue(String token) {
        this.value = token;
        return this;
    }
}
