<!--
    Lab 2 - Assignment B
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   MySQLHandler.php
-->

<?php
use Illuminate\Database\Capsule\Manager as dB;
class MySQLHandler{
    static public function connect(){
        $db = new dB();
        $db->addConnection([
        "driver" => _driver_,
        "host" => _host_,
        "database" => _database_,
        "username" => _username_,
        "password" => _password_
    ]);
    $db->setAsGlobal();
    $db->bootEloquent();
    }

    static public function get_data($start = 0){
        $all_requrds = dB::table("items")->skip($start)->take(_Pager_size_)->get();
        return $all_requrds;
    }

    static public function get_record_by_id($id){
        $searched_glasses = dB::table('items')->find($id);
        return $searched_glasses;
    }
}