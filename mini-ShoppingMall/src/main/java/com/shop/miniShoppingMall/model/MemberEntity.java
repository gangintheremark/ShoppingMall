package com.shop.miniShoppingMall.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member")
@Entity
public class MemberEntity {
    @Id
    private String userid;
    private String passwd;
    private String username;
    private String post;
    private String addr1;
    private String addr2;
    private String phone;
    private String email;

    public void changeMember(String username, String post, String addr1, String addr2, String phone, String email) {
        this.username = username;
        this.post = post;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.phone = phone;
        this.email = email;
    }
}
