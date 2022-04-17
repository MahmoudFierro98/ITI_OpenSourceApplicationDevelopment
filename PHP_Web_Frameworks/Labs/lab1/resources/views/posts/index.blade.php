@extends('layouts.app')

@section('title')Index @endsection

@section('content')
<div class="text-center">
    <a href="{{ route('posts.create') }}" class="mt-4 btn btn-success">Create Post</a>
</div>
<table class="table mt-4">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Posted By</th>
            <th scope="col">Created At</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
        @foreach ( $posts as $post)
        <tr>
            <td>{{ $post['id'] }}</th>
            <td>{{ $post['title'] }}</td>
            <td>{{ $post['post_creator'] }}</td>
            <td>{{ $post['created_at'] }}</td>
            <td>
                <a href="{{ route('posts.view', ['post' => $post['id']]) }}" class="btn btn-info">View</a>
                <a href="{{ route('posts.edit', ['post' => $post['id']]) }}" class="btn btn-primary">Edit</a>
                <a href="{{ route('posts.delete', ['post' => $post['id']]) }}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
        @endforeach
    </tbody>
</table>
@endsection