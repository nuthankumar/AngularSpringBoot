package com.exide.sfcrm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.AdvancePayCashView;

/**
 * 
 * @author vasavivr
 *
 */
@Repository
@Transactional
public interface TblAdvancePayRepository extends
		JpaRepository<AdvancePayCashView, Long> {

	@Query(value = "SELECT * FROM [TVFAdvanceAgentsLists] (?1) ORDER bY agentno OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY ", nativeQuery = true)
	public List<AdvancePayCashView> TVFAdvanceAgentsLists(String userName,
			Integer offSet, Integer limit);

	@Query(value = "SELECT  count (*)  FROM [TVFAdvanceAgentsLists] (?1)", nativeQuery = true)
	public Integer getCountForAdvancePayList(String userName);

	@Modifying
	@Query(value = "UPDATE TblAdvancePayCash ta SET ta.status = 1,ta.maker1UID = :makerId "
			+ ", ta.makerName = :makerName, ta.makerDate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()),ta.makerTime = GETDATE() "
			+ " where ta.status = 0 and ta.validFlag=1 and ta.paymentFlag=1 and "
			+ " ta.payRecoverFlag ='P' and ta.advDate = :advDate and ta.agentNo = :agentNo")
	Integer updateAdvancePayMakerCash(@Param("makerId") String makerId,
			@Param("makerName") String makerName,
			@Param("advDate") Integer advDate, @Param("agentNo") String agentNo);

	@Query(value = "SELECT * FROM [TVFAdvanceAgentsListsCheker] (?1) ORDER bY agentno OFFSET (?2)  ROWS FETCH NEXT (?3) ROWS ONLY ", nativeQuery = true)
	public List<AdvancePayCashView> TVFAdvanceAgentsListsChecker(
			String userName, Integer pageNumber, Integer limit);

	@Query(value = "SELECT  count (*)  FROM [TVFAdvanceAgentsListsCheker] (?1)", nativeQuery = true)
	public Integer getCountForAdvancePayCheckerList(String userName);

	@Modifying
	@Query(value = "UPDATE TblAdvancePayCash ta SET ta.status = 2,ta.checkerUID = :checkerId "
			+ ", ta.checkerName = :checkerName, ta.checkerDate=((YEAR(GETDATE()))*"
			+ "100+MONTH(GETDATE()))*100+DAY(GETDATE()),ta.checkerTime = GETDATE() "
			+ " where ta.status = 1 and ta.validFlag=1 and ta.paymentFlag=1 and "
			+ " ta.payRecoverFlag ='P' and ta.advDate = :advDate and ta.agentNo = :agentNo")
	Integer updateAdvancePayCheckerCash(@Param("checkerId") String checkerId,
			@Param("checkerName") String checkerName,
			@Param("advDate") Integer advDate, @Param("agentNo") String agentNo);

	@Query(value = "Delete from tmptblAdvancePayCash", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteTmptblAdvancePayCash();

	@Query(value = " EXEC [AdvancePaymentsEntry] ?1,?2,?3,?4,?5,?6,?7,?8,?9,?10 ", nativeQuery = true)
	@Modifying
	@Transactional
	public void executeAddAdvancePayments(String userId, String agentNo,
			Integer advDate, Integer effStartDt, Integer amount,
			Integer recoverable, String remarks, Integer maxRecoverblePerCycle,
			Integer netBalance, String confAttchment);



}
