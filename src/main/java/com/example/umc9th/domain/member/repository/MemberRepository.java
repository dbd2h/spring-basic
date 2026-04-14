package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("SELECT m FROM Member m WHERE m.id = :id")
    Member findMemberById(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Member m SET m.nickname = :nickname WHERE m.id = :id")
    int updateNickname(@Param("nickname") String nickname, @Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Member m SET m.phone_number = :phone_number WHERE m.id = :id")
    int updatePhoneNumber(@Param("phone_number") String phone_number, @Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Member m SET m.address = :address WHERE m.id = :id")
    int updateAddress(@Param("address") String address, @Param("id") Long id);

}
