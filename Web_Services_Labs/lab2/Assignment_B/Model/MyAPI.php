<!--
    Lab 2 - Assignment B
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   MyAPI.php
-->

<?php

class MyAPI{
    private $resource;
    private $resource_id;
    private $method = 'get';
    private $db;

    public function __construct($DB){
        $this->method = $this->get_method();
        $this->db = $DB;
        $this->read_resource();
        if($this->resource === "" || $this->resource_id === -1){
            $this->output(array("error"=>"Resource dosn't exist"),404);
        }else{
            $this->output($this->send_data($this->resource_id));
        }
    }

    public function output($data, $response_code=200){
        if($data === null){
            http_response_code(404);
            header('Content-Type: application/json');
            echo json_encode(array("error"=>"Resource dosn't exist"));
        }else{
            http_response_code($response_code);
            header('Content-Type: application/json');
            echo json_encode($data);
        }
        exit();
    }

    private function get_method(){
        $allowed = array("get","post","put","delete");
        if(in_array(strtolower($_SERVER["REQUEST_METHOD"]), $allowed)){
            return strtolower($_SERVER["REQUEST_METHOD"]);
        }else{
            $this->output(array("error"=>"method not allowed!"),405);
        }   
    }

    private function read_resource(){
        $url = $_SERVER["REQUEST_URI"];
        $sections = explode("/", $url);
        $allowed = array("items");
        $this->resource = in_array($sections[3], $allowed)?$sections[3]:"";
        if(isset($sections[4])){
            $this->resource_id = is_numeric($sections[4])?$sections[4]:-1;
        }
    }

    private function send_data($id){
        return $this->db->get_record_by_id($id);
    }
}