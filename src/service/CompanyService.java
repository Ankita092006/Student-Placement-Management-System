package service;

import dao.CompanyDAO;
import model.Company;

public class CompanyService {

    private CompanyDAO companyDAO;

    // Constructor
    public CompanyService() {
        companyDAO = new CompanyDAO();
    }

    // Add company
    public void addCompany(Company company) {
        companyDAO.addCompany(company);
    }

    // Display all companies
    public void showCompanies() {
        System.out.println("===== Available Companies =====");
        companyDAO.displayCompanies();
    }
}