<?php
class app_login extends CI_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
    }

    public function index_post()
    {
        
if ($_SERVER['REQUEST_METHOD']=='POST') {
    $username = $_POST['pass_index'];
    $password = $_POST['pass_nik'];

    $conn = mysqli_connect("localhost","root","","p_sumbersari"); 

    $sql = "SELECT * FROM pasien WHERE pas_index='$username'";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) === 1 ) {
        
        $row = mysqli_fetch_assoc($response);

        if ( password_verify($password, $row['pas_nik']) ) {
            
            $index['username'] = $row['pas_index'];
            $index['nama'] = $row['pas_nama'];

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);

        }

    }

}
    }
}
?>