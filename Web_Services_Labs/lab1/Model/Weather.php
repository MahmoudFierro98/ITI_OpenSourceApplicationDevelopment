<!--
    Lab 1
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   Weather.php
-->

<?php

class Weather implements Weather_Interface
{

    //put your code here
    private $url;

    public function __construct()
    {
    }

    public function get_cities()
    {
        $cities_json = file_get_contents(__CITIES_FILE);
        $cities_array = json_decode($cities_json, true);
        $egyptian_cities = array();

        foreach ($cities_array as $key => $value) {
            foreach ($value as $ke => $val) {
                if ($ke === "country" && $val === "EG") {
                    array_push($egyptian_cities, $cities_array[$key]);
                }
            }
        }
        return $egyptian_cities;
    }

    public function get_weather($cityid)
    {
        $api = __API . $cityid . __API_key;
        try {
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
            curl_setopt($ch, CURLOPT_URL, $api);
            curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
            $data = curl_exec($ch);
            curl_close($ch);

            $data_arr = json_decode($data, true);


            return $data_arr;
        } catch (Exception $e) {
            echo "message : " . $e->getMessage();
        }
    }

    public function get_current_time()
    {
        echo date("l") . " " . date("h") . " " . date("a") . "<br>";
        echo  date("d") . "th" . " " . date("F") . " " . date("Y") . "<br>";
    }
}
