<!--
    Lab 3 
    Author: Mahmoud Mohamed Kamal
    Date:   26-02-2022
    File:   User.php
-->

<?php
class User
{
    private $username;
    private $password;
    private $email;

    public function __construct($username, $password, $email)
    {
        $this->setEmail($email);
        $this->setUsername($username);
        $this->setPassword($password);
    }

    function getUsername()
    {
        return $this->username;
    }

    function getPassword()
    {
        return $this->password;
    }

    function getEmail()
    {
        return $this->email;
    }

    function setUsername($username)
    {
        $this->username = $username;
    }

    function setPassword($password)
    {
        $this->password = $password;
    }

    function setEmail($email)
    {
        $this->email = $email;
    }
}
