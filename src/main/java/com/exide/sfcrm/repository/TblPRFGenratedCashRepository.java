package com.exide.sfcrm.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.TblPRFGenratedCash;

@Repository
@Transactional
public interface TblPRFGenratedCashRepository extends
		JpaRepository<TblPRFGenratedCash, Long> {

	@Query(value = "SELECT agentNo,netAmount,netPayout,recoverableAmont,deviationAmt,advancePayout,advanceRecoverable,prfNoGenREF,prfGENDate,prfNo,prfComment from TblPRFGenratedCash where prfnogenref=?1")
	List<Object> findByprfNoGenREF(Integer prfNoGenREF);

	@Query(value = "update TblPRFGenratedCash set utrNo=?1,transferDate=?2 where prfNoGenREF=?3 and agentNo=?4", nativeQuery = true)
	@Modifying
	Integer updateUtrNo(String utrNo, Date transferDate, Integer prfNoGenREF,
			String agentNo);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status = 6 where status = 5 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void updateTblPRFGenratedCashApproverOne(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status=(CASE when netpayout<1000000 then 8 when netpayout>=1000000 then 7 End) where status = 6 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void updateTblPRFGenratedCashApproverTwo(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Query(value = "SELECT DISTINCT prfNo from TblPRFGenratedCash where status=8")
	List<String> findByprfNo();

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status = -6 where status = 5 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void rejectTblPRFGenratedCashApproverOne(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash SET status=(CASE when netpayout<1000000 then -8 when netpayout>=1000000 then -7 End) where status = 6 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void rejectTblPRFGenratedCashApproverTwo(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status = 8 where status = 7 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void updateTblPRFGenratedCashApproverThree(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status = -8 where status = 7 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void rejectTblPRFGenratedCashApproverThree(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status=8 where status = 6 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void updateTblPRFGenratedCashApproverTwoAdvance(
			@Param("prfNoGenRef") Integer prfNoGenRef);
	
	@Modifying
	@Query(value = "UPDATE TblPRFGenratedCash  SET status=-8 where status = 6 and prfNoGenREF= :prfNoGenRef ", nativeQuery = true)
	void rejectTblPRFGenratedCashApproverTwoAdvance(
			@Param("prfNoGenRef") Integer prfNoGenRef);

	

	
	@Query(value = " EXEC [UpdateUtrCash] ?1,?2,?3,?4", nativeQuery = true)
	@Modifying
	void executeUpdateUtrCash(String prfNo, String agentNo, String utrNo,
			String Date);


}
