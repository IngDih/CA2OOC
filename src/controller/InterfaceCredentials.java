package controller;

public interface InterfaceCredentials {


    /**
     *
     * method changes users password to string passed
     *
     * @return true if successfully updates, otherwise false
     */
    boolean changePassword(int id, String newPassword);

    /**
     *
     *   method changes users firstName to string passed
     *
     * @return true if successfully updates, otherwise false
     */
    boolean changeFirstName(int id, String newFirstName);


    /**
     *
     *   method changes users lastName to string passed
     *
     * @return true if successfully updates, otherwise false
     */
    boolean changeLastName(int id, String newFirstName);
}
