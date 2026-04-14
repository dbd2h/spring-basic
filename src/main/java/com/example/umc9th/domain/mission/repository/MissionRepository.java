package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MissionAccept;
import com.example.umc9th.global.enums.Boolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission,Long> {

    @Query("SELECT m FROM Mission m JOIN FETCH m.restaurant WHERE m.end_time < :time AND m.id < :idx ORDER BY m.id DESC LIMIT 5")
    List<Mission> findMissions(@Param("time") LocalDate time, @Param("idx") Long idx);

    @Query("SELECT ma FROM MissionAccept ma JOIN FETCH ma.mission JOIN FETCH ma.mission.restaurant JOIN FETCH ma.member WHERE ma.member.id = :member_id AND ma.is_continue = :is_continue AND ma.id < :idx ORDER BY ma.id desc LIMIT 5")
    List<MissionAccept> findAcceptedMission(@Param("member_id") Long member_id, @Param("is_continue") Boolean is_continue, @Param("idx") Long Mission_accept_id);
}
