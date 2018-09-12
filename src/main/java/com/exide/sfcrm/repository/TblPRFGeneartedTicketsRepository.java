package com.exide.sfcrm.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.TblPRFGenratedTickets;

@Transactional
@Repository
public interface TblPRFGeneartedTicketsRepository extends
		JpaRepository<TblPRFGenratedTickets, Integer> {

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedTickets SET status = 6 where status = 5 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void updateTransactionTicketApproverOne(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedTickets SET status = 8 where status = 6 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void updateTransactionTicketApproverTwo(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Query(value = "SELECT DISTINCT prfNo from TblPRFGenratedTickets where status=8")
	List<String> findByprfNo();

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedTickets SET utrNo=?1,transferDate=?2 where prfNoGenREF=?3 and agentNo=?4", nativeQuery = true)
	void updateTicketUtrNo(String utrNo, Date transferDate,
			Integer prfNoGenREF, String agentNo);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedTickets SET status = -6 where status = 5 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void rejectTransactionTicketApproverOne(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedTickets SET status = -8 where status = 6 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void rejectTransactionTicketApproverTwo(
			@Param("prfNoGenRef") Integer prfNoGenRef);

}
