<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    

 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>���� - ���</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="css/foods_styling5.css" >

<style>


  @media (min-width: 768px){
    .cardContainer > div {
      flex-basis: 49%;
    }
  }  
  @media (min-width: 425px){
    .cardContainer > div {
      flex-basis: 99%;
      /* width: 100%; */
    }
  }
</style>

</head>
<body>
  




  
<div class="container">
<header class="blog-header py-3">
  <div class="row flex-nowrap justify-content-between align-items-center">
    <div class="col-4 pt-1">
      <a class="link-secondary" href="#"> </a>
    </div>
    <div class="col-4 text-center">
      <span class="logo_txt">���ѹα� ��ǥ ���� Ŀ�´�Ƽ</span><a class="blog-header-logo" href="#" ><img class="logo_img" src="img/MZ logo.png" alt="logo"></a>
    </div>
    <div class="col-4 d-flex justify-content-end align-items-center">
      <a class="link-secondary" href="#" aria-label="Search">
      </a>
      </a>
      <a class="btn btn-sm btn-outline-secondary signIn" href="#">Sign in</a>
      <a class="btn btn-sm btn-outline-secondary signUp" href="#">Sign up</a>
    </div>
  </div>
</header>


<div class="bbb nav-scroller py-1 mb-2 ">
  <nav class="nav d-flex justify-content-around" >
    <a class="p-2 nav_css" href="#">�ѽ�</a>
    <a class="p-2 nav_cssSelect" href="#">�߽�</a>
    <a class="p-2 nav_css" href="#">���</a>
    <a class="p-2 nav_css" href="#">�Ͻ�</a>
    <a class="p-2 nav_css" href="#">����Ʈ</a>
    <a class="p-2 nav_css" href="#">��������</a>
  </nav>
</div>
</div>


<main class="container">
  
<div class="p-4 p-md-5 mb-4 text-white bg-dark">

  �̹��� �߰�
</div>

<div class="cardContainer">

  <div class="cardBox">
    <div class="">
      <img src="img/review03 rubijung.png" class="img-fluid img_cut"  alt="��ȭ�丮 �Ȱ� ����">
    </div>
    <div class="cardBoxText">
      <div class="card-body">
        <strong class="mb-lg-1 reviewCategory">�߽�</strong>
        <h5 class="card-title cardTitle">��ȭ�丮 �Ȱ�</h5>
        <p class="card-text mb-1 reviewDate">22.02.22 | ��ȸ�� 50ȸ</p>
        <p class="card-text mb-auto reviewNormal">��ġ : ���� ���Ǳ� �Ÿ��� 10-621 ���� 1��</p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">���� �Ұ�</p>
        <p class="card-text reviewNormal">Ǫ���� ��� �Ƴ����� ���
          Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���
        </p>
      </div>
    </div>
  </div>


    <div class="cardBox">
      <div class="cardImg">
        <img src="img/review03 rubijung.png" class="img-fluid  img_cut" alt="��ȭ�丮 �Ȱ� ����">
      </div>
      <div class="cardTxt">
        <div class="card-body">
          <strong class="mb-lg-1 reviewCategory">�߽�</strong>
          <h5 class="card-title cardTitle">¥�����</h5>
          <p class="card-text mb-1 reviewDate">20.02.10 | ��ȸ�� 50ȸ</p>
          <p class="card-text mb-auto reviewNormal">��ġ : ���� ���Ǳ� �ſ��� 16 1��</p>
          <p class="card-text mt-3 mb-auto reviewFeatureTitle">���� �Ұ�</p>
          <p class="card-text reviewNormal">�̺��� �� �� ������? ������ ������</p>
        </div>
      </div>
    </div>


    <div class="cardBox">
    <div class="">
      <img src="img/review03 rubijung.png" class="img-fluid img_cut"  alt="��ȭ�丮 �Ȱ� ����">
    </div>
    <div class="cardBoxText">
      <div class="card-body">
        <strong class="mb-lg-1 reviewCategory">�߽�</strong>
        <h5 class="card-title cardTitle">��ȭ�丮 �Ȱ�</h5>
        <p class="card-text mb-1 reviewDate">22.02.22 | ��ȸ�� 50ȸ</p>
        <p class="card-text mb-auto reviewNormal">��ġ : ���� ���Ǳ� �Ÿ��� 10-621 ���� 1��</p>
        <p class="card-text mt-3 mb-auto reviewFeatureTitle">���� �Ұ�</p>
        <p class="card-text reviewNormal">Ǫ���� ��� �Ƴ����� ���
          Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���Ǫ���� ��� �Ƴ����� ���
        </p>
      </div>
    </div>
  </div>
  
    <div class="cardBox">
      <div class="">
        <img src="img/MZ logo.png" class="img-fluid img_cut" alt="��ȭ�丮 �Ȱ� ����">
      </div>
      <div class="">
        <div class="card-body">
          <strong class="mb-lg-1 reviewCategory">�߽�</strong>
          <h5 class="card-title cardTitle">¥�����</h5>
          <p class="card-text mb-1 reviewDate">20.02.10 | ��ȸ�� 50ȸ</p>
          <p class="card-text mb-auto reviewNormal">��ġ : ���� ���Ǳ� �ſ��� 16 1��</p>
          <p class="card-text mt-3 mb-auto reviewFeatureTitle">���� �Ұ�</p>
          <p class="card-text reviewNormal">�̺��� �� �� ������? ������ ������</p>
        </div>
      </div>
    </div>

</div>




<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center pagination-lg">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>



<button type="button" class="btn btn-sm Writing" 
        style="float: right;"
        data-bs-toggle="button" autocomplete="off">�۾���
</button>


<br><br>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

