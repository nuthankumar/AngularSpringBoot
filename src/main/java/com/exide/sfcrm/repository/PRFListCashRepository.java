/**
 * 
 */
package com.exide.sfcrm.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exide.sfcrm.model.PRFListCashView;


/**
 * @author neethub
 *
 */
@Transactional
public interface PRFListCashRepository extends
		JpaRepository<PRFListCashView, Long> {

	@Query(value = " EXEC [GetPRFListCash] ?1,?2 ", nativeQuery = true)
	public List<PRFListCashView> getPRFListCash(String uId, Integer agentType);

	@Query(value = "select AgId from tblAgType where Agtypes = (?1)", nativeQuery = true)
	public BigDecimal getAgentTypeId(String agentTypeName);

	@Query(value = "select CAST(PRFPretext as varchar) from TblPRFNOPreText where transAutoId=1 ", nativeQuery = true)
	public String getprfPreText();

	@Query(value = "select ISNULL(MAX(PRFNoGenREF),0) + 1  from tblTransactionCash ", nativeQuery = true)
	public Integer getprfNoGenREF();

	@Query(value = "select  CAST(Agtypes as varchar) from tblAgType", nativeQuery = true)
	public List<String> getAgentTypes();
	
	@Query(value="select NetPayout from tmptblPRFListCash where tmptblPRFListCash.SelectRecrd='True' AND  (tmptblPRFListCash.NetPayout)<0", nativeQuery = true)
	public List<Double> getNetPayoutForNegativeTransaction();
	
	@Query(value = " EXEC [PRFCOMPLETECashNegative] ?1,?2,?3,?4,?5,?6,?7 ", nativeQuery = true)
	@Modifying
	@Transactional
	public void executePrfCompleteCashNegative(String userId,Integer agentType,String PRFNo,String agentNo,String PrfNumGen,String comment,Float PRFAmount);
	
	@Query(value = " EXEC [PRFCOMPLETECash] ?1,?2,?3,?4,?5,?6", nativeQuery = true)
	@Modifying
	@Transactional
	public void executePrfCompleteCashPositive(String PRFNo,String agentNo,String PrfNumGen,String comment,String agentType,Float PRFAmount);
	
	@Query(value = " EXEC [PRFRecoverbleCash] ?1,?2,?3,?4,?5,?6,?7 ", nativeQuery = true)
	@Modifying
	@Transactional
	public void executePrfRecoverbleCash(String userId, Integer agentType,String prfNumber,String agentNo,String prfGenRef,String prfComment,Float prfAmount);

	@Query(value = "select Count(TransAutoId) from tmptblPRFListCash where tmptblPRFListCash.SelectRecrd='True' AND  ISNULL(tmptblPRFListCash.NetPayout,0)>=0", nativeQuery = true)
    public Integer getCountOfPositiveNetAmount();
	
	@Query(value = "select ISNULL(Count(TransAutoId),0) from tmptblPRFListCash where tmptblPRFListCash.SelectRecrd='True' AND  ISNULL(tmptblPRFListCash.NetPayout,0)>0", nativeQuery = true)
    public Integer getCountOfPositiveNetAmountType9();
	
	@Query(value = "select ISNULL(Count(TransAutoId),0) from tmptblPRFListCash where tmptblPRFListCash.SelectRecrd='True' AND  ISNULL(tmptblPRFListCash.NetPayout,0) < 0", nativeQuery = true)
    public Integer getCountOfNegativeNetAmount();
	
	@Query(value="select NetPayout from tmptblPRFListCash where tmptblPRFListCash.SelectRecrd='True' AND  (tmptblPRFListCash.NetPayout) > = 0", nativeQuery = true)
	public List<Double> getNetPayoutForPositiveTransaction();
	
	@Query(value="select NetPayout from tmptblPRFListCash where tmptblPRFListCash.SelectRecrd='True' AND  (tmptblPRFListCash.NetPayout) >  0 AND tmptblPRFListCash.AgentNo = ?1" , nativeQuery = true)
	public List<Double> getNetPayoutForPositiveTransactionType9(String agentNo);
	
	
	@Query(value = "INSERT INTO tblPRFGenratedCash ( AgentNo, AgentName, TransDate, NetAmount, RecoverableAmont," +
				"DeviationAmt, AdvancePayout, AdvanceRecoverable, MaxRecoverableAmt, NetPayout, BranchCode, BankACNumber, " +
				"IFSCCode, IRDNO, PRFAmount, PRFNoGenREF, PRFNo, PRFGENDate, PRFComment, Agtypes, CostCentreCode, " +
				"Channel, LocationBranchCode, ModeOfPayment, CreatedDate, Status,Cid ) " +
	            "SELECT tbltmpPRFGenSupportTbl.AgentNo, tbltmpPRFGenSupportTbl.AgentName, " +
				"tbltmpPRFGenSupportTbl.TranDate, tbltmpPRFGenSupportTbl.NetAmount, tbltmpPRFGenSupportTbl.RecoverbleAmount, " +
				"tbltmpPRFGenSupportTbl.DeviationAmt, tbltmpPRFGenSupportTbl.AdvancePayout, tbltmpPRFGenSupportTbl.AdvanceRecoverable, " +
				"tbltmpPRFGenSupportTbl.MaxRecoverableAmt, tbltmpPRFGenSupportTbl.NetPayout, tbltmpPRFGenSupportTbl.BranchCode, " +
				"tbltmpPRFGenSupportTbl.BankACNumber, tbltmpPRFGenSupportTbl.IFSCCode, tbltmpPRFGenSupportTbl.IRDNO, " +
				"tbltmpPRFGenSupportTbl.PRFAmount, tbltmpPRFGenSupportTbl.PRFNoGenREF, tbltmpPRFGenSupportTbl.PRFNo, " +
				"tbltmpPRFGenSupportTbl.PRFGENDate, tbltmpPRFGenSupportTbl.PRFComment, tbltmpPRFGenSupportTbl.Agtypes, " +
				"tbltmpPRFGenSupportTbl.CostCentreCode, tbltmpPRFGenSupportTbl.Channel, tbltmpPRFGenSupportTbl.LocationBranchCode, " +
				"tbltmpPRFGenSupportTbl.ModeOfPayment, (CAST(YEAR(GETDATE()) AS BIGINT)*100+MONTH(GETDATE()))*100+DAY(GETDATE()) " +
				"AS CreateDate, 5 AS Expr2, ?1 FROM tbltmpPRFGenSupportTbl ", nativeQuery = true)
	@Modifying
	public void updateTblPrfGeneratedCash(Integer cId);
	
	@Transactional
	@Modifying
	@Query(value = " EXEC [AdvancePayment] ?1,?2,?3,?4 ", nativeQuery = true)
	public void executeAdvancePaymentCash(String prfNo,String prfGenRef,String prfComment,Float prfAmount);
	
	@Transactional
	@Modifying
	@Query(value = " EXEC [PRFTypeAdvance] ?1,?2,?3,?4,?5,?6 ", nativeQuery = true)
	public void executePRFTypeAdvance(String prfNo,String prfGenRef,String prfComment,String agentId,Integer cId, Float prfAmount);
	
	@Query(value = "Delete from tmptblPRFListCash", nativeQuery = true)
	@Modifying
	@Transactional
    public void deleteTmptblPRFListCash();
	
	@Query(value = "Delete From dbo.tbltmpPRFGenSupportTbl", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteTbltmpPRFGenSupportTbl();
	
	@Query(value = "Update tblTransactionCash set tblTransactionCash.SelectRecrd = 'True' where tblTransactionCash.TransAutoId = ?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateTblTransactionCashForSelectedRecord(Integer transAutoId);
	
	@Query(value = "Update tblTransactionCash set tblTransactionCash.SelectRecrd = 'False' where tblTransactionCash.TransAutoId = ?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateTblTransactionCashForUnSelectRecord(Integer transAutoId);
	
	@Query(value = "Update tmptblPRFListCash set tmptblPRFListCash.SelectRecrd = 'False' where tmptblPRFListCash.SelectId = ?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void updatetmptblPRFListCashUnSelectRecord(Integer SelectId);
	
	
	@Query(value = "Update tmptblPRFListCash set tmptblPRFListCash.SelectRecrd = 'True' where tmptblPRFListCash.SelectId = ?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void updatetmptblPRFListCashSelectRecord(Integer SelectId);
	
}
