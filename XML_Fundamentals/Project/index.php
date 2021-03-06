<!--
    XML Project
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   index.php
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>XML - Project | By: Mahmoud M.Kamal</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <h1>XML Project - Employees List</h1>
    <?PHP
    session_start();
    require_once("config.php");
    $data = new DOMDocument();
    $data->load(XML_FILE, LIBXML_NOBLANKS);
    $rootElement = $data->getElementsByTagName(ROOT_ELEMENT)[0];
    $end = $rootElement->childElementCount - 1;
    ?>
    <form class="search" method="POST" action="">
        <input type="text" name="search" placeholder="Enter a Name" />
        <input type="submit" value="Search" />
    </form>
    <div class="msg"><?= $_SESSION['operation'] ?? ''; ?></div>
    <br />
    <form method="POST" action="">
        <?php
        unset($_SESSION['operation']);
        if (!isset($_SESSION['index'])) {
            $_SESSION['index'] = 0;
        }
        if (isset($_POST['search'])) {
            if (empty($_POST['search'])) {
                $_SESSION['index'] = 0;
            } else {
                $searchKey = $_POST['search'];
                $count = 0;
                foreach ($rootElement->childNodes as $childchildNode) {
                    $node = $childchildNode->getElementsByTagName(NAME_TAG)->item(0);
                    if ($node->nodeValue == $searchKey) {
                        break;
                    } else {
                        ++$count;
                    }
                }
                if ($count <= $end) {
                    $_SESSION['index'] = $count;
                    $_SESSION['operation'] = "Found";
                } else {
                    $_SESSION['operation'] = "Not Found";
                }
            }
            unset($_POST['search']);
            header("Location: index.php");
        }
        $element = $data->getElementsByTagName(ELEMENT)[$_SESSION['index']];
        echo "<div>";
        echo "<span>ID: " . $_SESSION['index'] . "</span>";
        foreach ($element->childNodes as $childchildNode) {
        ?>
            <label for="<?= $childchildNode->nodeName ?>"><?= $childchildNode->nodeName ?></label>
            <input type="text" name="<?= $childchildNode->nodeName ?>" id="<?= $childchildNode->nodeName ?>" value="<?= $childchildNode->nodeValue ?>">
        <?php
        }
        ?>
        </div>
        <br />
        <div class="btns">
            <input type="submit" id='insert' value="Insert" name="insert">
            <input type="submit" id='edit' value="Edit" name="edit">
            <input type="submit" id='delete' value="Delete" name="delete">
            <input type="submit" id='prev' value="Prev" name="prev">
            <input type="submit" id='next' value="Next" name="next">
        </div>
    </form>
    <?php
    if (isset($_POST['insert'])) {
        $newElement = $data->createElement(ELEMENT, '');
        $name = $data->createElement(NAME_TAG, $_POST[NAME_TAG]);
        $newElement->appendChild($name);
        $phone = $data->createElement(PHONE_TAG, $_POST[PHONE_TAG]);
        $newElement->appendChild($phone);
        $email = $data->createElement(EMAIL_TAG, $_POST[EMAIL_TAG]);
        $newElement->appendChild($email);
        $address = $data->createElement(ADDRESS_TAG, $_POST[ADDRESS_TAG]);
        $newElement->appendChild($address);
        $rootElement->appendChild($newElement);
        $data->formatOutput = true;
        $data =  $data->save(XML_FILE);
        $_SESSION['index'] = $end + 1;
        $_SESSION['operation'] = 'Inserted';
        header("Location: index.php");
    }
    if (isset($_POST['edit'])) {
        foreach ($element->childNodes as $childchildNode) {
            $node = $element->getElementsByTagName($childchildNode->nodeName)->item(0);
            $node->nodeValue = $_POST[$childchildNode->nodeName];
            $element->replaceChild($node, $node);
        }
        $data->formatOutput = true;
        $saveData = $data->save(XML_FILE);
        $_SESSION['operation'] = 'Edited';
        header("Location: index.php");
    }
    if (isset($_POST['delete'])) {
        $rootElement->removeChild($element);
        $data->formatOutput = true;
        $saveData = $data->save(XML_FILE);
        ($_SESSION['index'] == 0) ? $_SESSION['index'] = 0 : --$_SESSION['index'];
        $_SESSION['operation'] = 'Deleted';
        header("Location: index.php");
    }
    if (isset($_POST['prev'])) {
        ($_SESSION['index'] == 0) ? $_SESSION['index'] = $end : --$_SESSION['index'];
        header("Location: index.php");
    }
    if (isset($_POST['next'])) {
        ($_SESSION['index'] >= $end) ? $_SESSION['index'] = 0 : ++$_SESSION['index'];
        header("Location: index.php");
    }
    ?>
    <marquee>Created by: <a href="https://www.linkedin.com/in/mahmoudfierro98/" target = _blank>Mahmoud Mohamed Kamal</a></marquee>
</body>

</html>