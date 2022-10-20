package org.zerock.club.entity;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ClubMember extends BaseEntity{
    
    @Id
    private String email;
    
    private String password;
    
    private String name;
    
    private boolean fromSocial; //소셜 로그인 가능 여부

    @ElementCollection(fetch = FetchType.LAZY) //지연 로딩
    @Builder.Default
    private Set<ClubMemberRole> roleSet = new HashSet<>();

    public void addMemberRole(ClubMemberRole clubMemberRole){
        roleSet.add(clubMemberRole); //3가지의 룰을 추가하여 테이블 생성
    }//Hibernate:
//    create table club_member (
//            email varchar(255) not null,
//    moddate datetime(6),
//    regdate datetime(6),
//    from_social bit not null,
//    name varchar(255),
//    password varchar(255),
//    primary key (email)
//    ) engine=InnoDB
//    Hibernate:
//
//    create table club_member_role_set (
//            club_member_email varchar(255) not null,
//    role_set integer
//    ) engine=InnoDB
//    Hibernate:
//
//    alter table club_member_role_set
//    add constraint FKbfljk8ybtolixxc88osbodrek
//    foreign key (club_member_email)
//    references club_member (email)

}
