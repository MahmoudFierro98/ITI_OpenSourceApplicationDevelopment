@extends('layouts.app')

@section('title')View @endsection

@section('content')
<div class="card my-3">
    <h5 class="card-header">Post Info</h5>
    <div class="card-body">
        <div>
            <span style="font-size: 1.2rem; font-weight: bold">Title: </span>
            {{$post->title}}
        </div>
        @if($post->image)
        <div style="width: 20%">
            <!-- <img class="img-fluid" src="/images/{{ $post->image }}" alt=""> -->
            <img class="img-fluid" src="/{{ $post->image }}" alt="">
        </div>
        @endif
        <div>
            <span style="font-size: 1.2rem; font-weight: bold">Description: </span>
            <p class="card-text">{{$post->description}}</p>
        </div>
    </div>
</div>

@if($post->user)
<div class="card my-3">
    <h5 class="card-header">Post Creator Info</h5>
    <div class="card-body">
        <div>
            <span style="font-size: 1.2rem; font-weight: bold">Name: </span>
            {{$post->user->name}}
        </div>
        <div>
            <span style="font-size: 1.2rem; font-weight: bold">Email: </span>
            {{$post->user->email}}
        </div>
        <div>
            <span style="font-size: 1.2rem; font-weight: bold">Created At: </span>
            {{ \Carbon\Carbon::parse($post->user->created_at)->format('l jS \\of F Y h:i:s A') }}
        </div>
    </div>
</div>
@endif


<div class="card">
    <h5 class="card-header">
        Comments
    </h5>
    <div class="card-body">
        <form action="{{route('comments.store', ['user_id' => Auth::id(), 'commentable_id' => $post['id'], 'commentable_type' => get_class($post)])}}" method="POST">
            @csrf
            <div class="form-group">
                <textarea name="body" id="body" cols="15" rows="4" class="form-control" placeholder="Your comment here"></textarea>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add Comment</button>
            </div>
        </form>
        @if(count($post->comments) > 0)
        @foreach($post->comments as $comment)
        <div class="card">
            <div class="card-header">
                {{$comment->user->name}}:
            </div>
            <div class="card-body">
                <div>
                    <span style="font-size: 1.2rem; font-weight: bold">Comment: </span>
                    {{$comment->body}}
                </div>
                <div>
                    <span style="font-size: 1rem; font-weight: bold">Created At: </span>
                    {{ \Carbon\Carbon::parse($comment->created_at)->format('l jS \\of F Y h:i:s A') }}
                </div>
                <!-- <div>
                    <span style="font-size: 1rem; font-weight: bold">By: </span>
                    {{ $comment->user->name }}
                </div> -->
            </div>
        </div>
        @endforeach
        @else
        <div>No comments yet</div>
        @endif
    </div>
</div>
@endsection