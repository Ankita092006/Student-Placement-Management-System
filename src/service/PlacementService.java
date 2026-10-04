package service;

import dao.ApplicationDAO;
import dao.CompanyDAO;

public class PlacementService {

    private CompanyDAO companyDAO = new CompanyDAO();
    private ApplicationDAO applicationDAO = new ApplicationDAO();

    // Show available companies
    public void showCompanies() {

        System.out.println("===== Available Companies =====");

        companyDAO.displayCompanies();
    }

    // Student applies for a company
    public void applyForCompany(int studentId, int companyId) {

        applicationDAO.applyForCompany(studentId, companyId);
    }

    // Show all applications
    public void showApplications() {

        System.out.println("===== Applications =====");

        applicationDAO.displayApplications();
    }

    // Update application status
    public void updateApplicationStatus(int applicationId,
                                        String status) {

        applicationDAO.updateStatus(applicationId, status);
    }
}