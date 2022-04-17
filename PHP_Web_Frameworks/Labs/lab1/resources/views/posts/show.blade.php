@extends('layouts.app')

@section('title')View @endsection

@section('content')
<form>
    <input type="HIDDEN" name="id" value={{ $post['id'] }} class="form-control" id="exampleFormControlInput1" disabled>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Title</label>
        <input type="text" name="title" value={{ $post['title'] }} class="form-control" id="exampleFormControlInput1" disabled>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
        <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3" disabled>{{ $post['description'] }}</textarea>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Post Creator</label>
        <input type="text" name="creator" value={{ $post['post_creator'] }} class="form-control" disabled>
    </div>
</form>
@endsection

<!-- 
@section('content')
<div class=" container border border-dark rounded my-5 ">
    <div class="mx-5">
        <p class="fw-bold">post Creator Info</p>
        <hr>
        <p>Id: <span> {{ $post['id']}} </span>
        <p>
        <p>Name: <span> {{ $post['post_creator']}}</span>
        <p>
        <p>title: <span> {{ $post['title']}} </span> </p>
        <p>created_at: <span> {{$post['created_at']}}</span>
    </div>
</div>
@endsection -->