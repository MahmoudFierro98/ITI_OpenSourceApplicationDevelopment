<?php

namespace App\Http\Controllers;

use App\Models\Post;
use App\Models\User;
use App\Models\Comment;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\File;
use App\Http\Requests\StorePostRequest;

class PostController extends Controller
{
    public function index()
    {
        // $posts = Post::all();
        $posts = post::paginate(15);
        return view('posts.index', [
            'posts' => $posts,
        ]);
    }

    public function create()
    {
        return view('posts.create');
    }

    public function store(StorePostRequest $request)
    {
        if ($request->file('image')) {
            // $image = $request->file('image');
            // $imageRename = $request['title'] . '.' . $image->getClientOriginalExtension();
            // $image->move(public_path('images'), $imageRename);
            $imagePath = $request->file('image')->store('public/images');
            Post::create([
                'title' =>  $request['title'],
                'description' =>  $request['description'],
                'user_id' => $request['user_id'],
                // 'image' => $imageRename,
                'image' => str_replace('public', 'storage', $imagePath)
            ]);
        } else {
            Post::create([
                'title' =>  $request['title'],
                'description' =>  $request['description'],
                'user_id' => $request['user_id']
            ]);
        }
        // return redirect()->route('posts.index')->with('success', "post created");
        return to_route('posts.index');
    }

    public function show($postId)
    {
        $post = post::find($postId);
        return view("posts.show", [
            'post' => $post
        ]);
    }

    public function edit($postId)
    {
        $post = Post::find($postId);
        return view('posts.edit', [
            'post' => $post
        ]);
    }

    public function update(Request $request, $postId)
    {
        $users = User::all();
        $post = Post::find($postId);
        $request->validate([
            'title' => 'required|min:3|unique:posts,title,' . $post->title . ',title',
            'description' => 'required|min:10',
            'image' => 'mimes:jpeg,png,jpg,gif'
        ]);

        if ($request->file('image')) {
            Storage::delete(str_replace('storage', 'public', $post->image));
            $imagePath = $request->file('image')->store('public/images');
            // File::delete(public_path('images/'.$post['image'])); 
            // $image = $request->file('image');
            // $imageRename = $request['title'] . '.' . $image->getClientOriginalExtension();
            // $image->move(public_path('images'), $imageRename);
        } else {
            $imagePath = $post->image;
        }

        $post->update([
            'title' => $request['title'],
            'description' => $request['description'],
            // 'image' => $imageRename,
            'image' => str_replace('public', 'storage', $imagePath),
        ]);
        // return to_route('posts.index');
        return view('posts.show', [
            'post' => $post,
            'users' => $users,
        ]);
    }

    public function delete($postId)
    {
        $post = post::find($postId);
        // File::delete(public_path('images/'.$post['image'])); 
        Storage::delete(str_replace('storage', 'public', $post->image));
        post::where('id', $postId)->delete();
        Comment::where('commentable_id', $postId)->delete();
        return to_route('posts.index');
    }
}
