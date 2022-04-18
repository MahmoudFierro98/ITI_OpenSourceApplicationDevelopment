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
        <input type="text" name="creator" value={{ $post->user->name }} class="form-control" disabled>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Created At</label>
        <input type="text" name="creator" value={{ $post->created_at}} class="form-control" disabled>
    </div>
</form>	
@endsection