package com.useinsider;

import com.useinsider.pages.CareersPage;
import com.useinsider.pages.HomePage;
import com.useinsider.pages.QAPage;
import com.useinsider.pages.OpenPositionsPage;

public class Pages {


    private HomePage homePage;
    private CareersPage careersPage;
    private QAPage qaPage;
    private OpenPositionsPage openPositionsPage;


    public HomePage homePage() {
        if (homePage == null) homePage = new HomePage();
        return homePage;
    }

    public CareersPage careersPage(){
        if (careersPage == null)
            careersPage = new CareersPage();
        return careersPage;
    }
    public QAPage qaPage(){
        if (qaPage == null)
            qaPage = new QAPage();
        return qaPage;
    }

    public OpenPositionsPage openPositionsPage(){
        if (openPositionsPage == null)
            openPositionsPage = new OpenPositionsPage();
        return openPositionsPage;
    }

}
