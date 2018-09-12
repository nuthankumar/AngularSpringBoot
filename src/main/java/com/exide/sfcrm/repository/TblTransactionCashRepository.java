package com.exide.sfcrm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.TblTransactionCash;

/**
 * @author neethub
 *
 */
@Repository
@Transactional
public interface TblTransactionCashRepository extends
		JpaRepository<TblTransactionCash, Long> {

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = 1,tc.maker1UID = :makerId "
			+ ", tc.makerName = :makerName , tc.makerDate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.makerTime = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status in (0,-2,-3,-4,-5,-6,-7,-8) and tc.validFlag=1 and "
			+ "tc.paymentFlag=1 and tc.contestID = :contestId and tc.agentNo = :agentNo")
	Integer updateTblTransactionCashMaker(@Param("makerId") String makerId,
			@Param("makerName") String makerName,
			@Param("remarks") String remarks,
			@Param("contestId") Integer contestId,
			@Param("agentNo") String agentNo);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = 2,tc.checkerUID = :checkerId "
			+ ", tc.checkerName = :checkerName, tc.checkerDate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.checkerTime = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status = 1 and tc.validFlag=1 and "
			+ "tc.paymentFlag=1 and tc.contestID = :contestId and tc.agentNo = :agentNo")
	Integer updateTblTransactionCashChecker(
			@Param("checkerId") String checkerId,
			@Param("checkerName") String checkerName,
			@Param("remarks") String remarks,
			@Param("contestId") Integer contestId,
			@Param("agentNo") String agentNo);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = 6,tc.approver1UID= :approverId "
			+ ", tc.approver1Name = :approverName , tc.approver1date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.approver1Time = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status = 5 and tc.validFlag>=1 and "
			+ "tc.paymentFlag=2 and tc.entryFlag in (1,2) and tc.prfNoGenREF= :prfNoGenRef")
	void updateTransactionCashApproverOne(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("prfNoGenRef") Integer prfNoGenRef,
			@Param("remarks") String remarks);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status= (CASE when balancepayable<1000000 then 8 when balancepayable>=1000000 then 7 End),tc.approver2UID= :approverId "
			+ ", tc.approver2Name = :approverName , tc.approver2Date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.approver2Time = GETDATE() "
			+ ", tc.approver2Remarks = :remarks where tc.status = 6 and tc.validFlag>=1 and "
			+ "tc.paymentFlag=2 and tc.entryFlag in (1,2) and tc.prfNoGenREF= :prfNoGenRef")
	void updateTransactionCashApproverTwo(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("remarks") String remarks,
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = -1,tc.maker1UID = :makerId "
			+ ", tc.makerName = :makerName , tc.makerDate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.makerTime = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status = 0 and tc.validFlag=1 and "
			+ "tc.paymentFlag=1 and tc.contestID = :contestId")
	Integer rejectTblTransactionCashMaker(@Param("makerId") String makerId,
			@Param("makerName") String makerName,
			@Param("remarks") String remarks,
			@Param("contestId") Integer contestId);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = -2,tc.checkerUID = :checkerId "
			+ ", tc.checkerName = :checkerName, tc.checkerDate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.checkerTime = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status = 1 and tc.validFlag=1 and "
			+ "tc.paymentFlag=1 and tc.contestID = :contestId")
	Integer rejectTblTransactionCashChecker(
			@Param("checkerId") String checkerId,
			@Param("checkerName") String checkerName,
			@Param("remarks") String remarks,
			@Param("contestId") Integer contestId);

	@Modifying
	@Query(value = "UPDATE TblTransactionCash tc SET tc.status = 4,tc.deviationApprName= :deviationApprname "
			+ ",tc.deviationApprUID= :deviationApprId ,tc.deviationApprdate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()),tc.deviationApprTime= GETDATE() "
			+ ",tc.deviationApprRemarks= :remarks  where tc.validFlag=1 and tc.paymentFlag =1 and "
			+ " tc.status=2  and tc.entryFlag=1  and tc.contestID = :contestId and tc.agentNo = :agentNo ")
	Integer updateTransactionCashDeviation(
			@Param("deviationApprId") String deviationApprId,
			@Param("deviationApprname") String deviationApprname,
			@Param("remarks") String remarks,
			@Param("contestId") Integer contestId,
			@Param("agentNo") String agentNo);

	@Modifying
	@Query(value = "UPDATE TblTransactionCash tc SET tc.status = -4,tc.deviationApprName= :deviationApprname "
			+ ",tc.deviationApprUID= :deviationApprId ,tc.deviationApprdate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()),tc.deviationApprTime= GETDATE() "
			+ ",tc.deviationApprRemarks= :remarks  where tc.validFlag=1 and tc.paymentFlag =1 and "
			+ " tc.status=2  and tc.entryFlag=1  and tc.contestID = :contestId and tc.agentNo = :agentNo")
	Integer rejectTransactionCashDeviation(
			@Param("deviationApprId") String deviationApprId,
			@Param("deviationApprname") String deviationApprname,
			@Param("remarks") String remarks,
			@Param("contestId") Integer contestId,
			@Param("agentNo") String agentNo);

	@Query(value = " EXEC [AddDeviation] ?1,?2,?3,?4,?5,?6,?7,?8,?9,?10", nativeQuery = true)
	@Modifying
	@Transactional
	public void executeAddDeviation(String userId, Integer contestId,
			String agentNo, String contestName, Integer startDate,
			Integer endDate, Integer loadDate, Float netAmount,
			String attachment, String remarks);

	@Query(value = " EXEC [NetPayableCalc] ", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateNetPayableCalc();

	@Query(value = " EXEC [BalancePayableCalc] ", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateBalancePayableCalc();

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = -6,tc.paymentFlag=1,tc.approver1UID= :approverId "
			+ ", tc.approver1Name = :approverName , tc.approver1date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.approver1Time = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status = 5 and tc.validFlag>=1 and "
			+ "tc.paymentFlag=2 and tc.entryFlag in (1,2) and tc.prfNoGenREF= :prfNoGenRef")
	void rejectTransactionCashApproverOne(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("prfNoGenRef") Integer prfNoGenRef,
			@Param("remarks") String remarks);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status= (CASE when balancepayable<1000000 then -8 when balancepayable>=1000000 then -7 End),tc.paymentFlag=1,tc.approver1UID= :approverId "
			+ ", tc.approver1Name = :approverName , tc.approver1date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.approver1Time = GETDATE() "
			+ ", tc.approver1Remarks = :remarks where tc.status = 6 and tc.validFlag>=1 and "
			+ "tc.paymentFlag=2 and tc.entryFlag in (1,2) and tc.prfNoGenREF= :prfNoGenRef")
	void rejectApproverTwoTransactionCash(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("remarks") String remarks,
			@Param("prfNoGenRef") Integer prfNoGenRef);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = 8,tc.approver3UID= :approverId "
			+ ", tc.approver3Name = :approverName , tc.approver3Date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.approver3Time = GETDATE() "
			+ ", tc.approver3Remarks = :remarks where tc.status = 7 and tc.validFlag>=1 and "
			+ "tc.paymentFlag=2 and tc.entryFlag in (1,2) and tc.prfNoGenREF= :prfNoGenRef")
	void updateTransactionCashApproverThree(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("prfNoGenRef") Integer prfNoGenRef,
			@Param("remarks") String remarks);

	@Modifying
	@Query("UPDATE TblTransactionCash tc SET tc.status = -8,tc.paymentFlag=1,tc.approver3UID= :approverId"
			+ ", tc.approver3Name = :approverName , tc.approver3Date=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()) ,  tc.approver3Time = GETDATE() "
			+ ", tc.approver3Remarks = :remarks where tc.status = 7 and tc.validFlag>=1 and "
			+ "tc.paymentFlag=2 and tc.entryFlag in (1,2) and tc.prfNoGenREF= :prfNoGenRef")
	void rejectTransactionCashApproverThree(
			@Param("approverId") String approverId,
			@Param("approverName") String approverName,
			@Param("prfNoGenRef") Integer prfNoGenRef,
			@Param("remarks") String remarks);

}
