package com.exide.sfcrm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.TblAdvancePayCash;

@Repository
public interface TblAdvancePayCashRepository extends
		JpaRepository<TblAdvancePayCash, Long> {

	@Transactional
	@Modifying
	@Query(value = " UPDATE  TblAdvancePayCash SET Status = 6 , Approver1UID = :approverId , "
			+ " Approver1Name = :approverName , Approver1date = REPLACE((CAST((CONVERT(Date,GETDATE())) as VARCHAR(50))) , '-', '')  , "
			+ " Approver1Time = GETDATE() , Approver1Remarks = :remarks "
			+ " where Status = 5 And ValidFlag >= 1 And PaymentFlag = 2 "
			+ " And PRFNoGenREF = :prfNoGenRef", nativeQuery = true)
	void updateTransactionCashApproverOneAdvance(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("prfNoGenRef") Integer prfNoGenRef,
			@Param("remarks") String remarks);

	@Transactional
	@Modifying
	@Query(value = "UPDATE TblAdvancePayCash SET Status=8, approver2UID= :approverId "
			+ ", approver2Name = :approverName , approver2Date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  approver2Time = GETDATE() "
			+ ", approver2Remarks = :remarks where Status = 6 And ValidFlag >= 1 And PaymentFlag = 2 "
			+ "And PRFNoGenREF = :prfNoGenRef", nativeQuery = true)
	void updateTransactionCashApproverTwo(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("remarks") String remarks,
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Transactional
	@Modifying
	@Query(value = " UPDATE  TblAdvancePayCash SET Status = -6 , Approver1UID = :approverId , "
			+ " Approver1Name = :approverName , Approver1date = REPLACE((CAST((CONVERT(Date,GETDATE())) as VARCHAR(50))) , '-', '')  , "
			+ " Approver1Time = GETDATE() , Approver1Remarks = :remarks "
			+ " where Status = 5 And ValidFlag >= 1 And PaymentFlag = 2 "
			+ " And PRFNoGenREF = :prfNoGenRef", nativeQuery = true)
	void rejectTransactionCashApproverOneAdvance(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("prfNoGenRef") Integer prfNoGenRef,
			@Param("remarks") String remarks);

	@Transactional
	@Modifying
	@Query(value = "UPDATE TblAdvancePayCash SET Status=-8, approver2UID= :approverId "
			+ ", approver2Name = :approverName , approver2Date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  approver2Time = GETDATE() "
			+ ", approver2Remarks = :remarks where Status = 6 And ValidFlag >= 1 And PaymentFlag = 2 "
			+ "And PRFNoGenREF = :prfNoGenRef", nativeQuery = true)
	void rejectTransactionCashApproverTwoAdvance(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("remarks") String remarks,
			@Param("prfNoGenRef") Integer prfNoGenRef);

}
