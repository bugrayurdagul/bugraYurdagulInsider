package tests;

import com.useinsider.Pages;
import com.useinsider.baseTest.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InsiderTestCase extends BaseTest {

    private final Pages pages = new Pages();

    @Test
    public void test1_visitInsiderPageAndCheckIfHomePageLoaded() {
        pages.homePage().checkHomePageIsOpened();
        pages.homePage().acceptCookies();
    }

    @Test
    public void test2_goToCareersPageViaNavBarAndCheckIfItemsLoaded() {
        pages.homePage().goToCareersPage();
        pages.careersPage().checkBlocksAreOpen();
    }

    @Test
    public void test3_goToQAPageViaUrlFilterJobsAndCheckIfJobsListed() {
        pages.qaPage().goToQAPage();
        pages.qaPage().goToQAOpenPositionsPage();
        pages.openPositionsPage().filterForQAJobs();
    }

    @Test
    public void test4_checkTitleDepartmentAndLocationInfoInJobCards() {
        pages.openPositionsPage().checkForJobListingsInfos();
    }

    @Test
    public void test5_clickViewRoleButtonAndCheckIfItRedirectsToLeverPage() {
        pages.openPositionsPage().hoverAndClickViewRoleButton();
        pages.openPositionsPage().checkIfLeverPageRedirected();
    }
}
