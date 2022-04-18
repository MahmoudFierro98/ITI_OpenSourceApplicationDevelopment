<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Post;
use App\Models\User;

class PostController extends Controller
{

    // public static $posts = [
    //     ['id' => 0, 'title' => 'Laravel', 'description' => "Laravel", 'post_creator' => 'Ahmed', 'created_at' => '2022-04-16 10:37:00'],
    //     ['id' => 1, 'title' => 'PHP', 'description' => "PHP", 'post_creator' => 'Mohamed', 'created_at' => '2022-04-16 10:37:00'],
    //     ['id' => 2, 'title' => 'Javascript', 'description' => "JS", 'post_creator' => 'Ali', 'created_at' => '2022-04-16 10:37:00'],
    // ];

    public function index()
    {
        $posts = Post::all();
        return view('posts.index', [
            'posts' => $posts,
        ]);
    }

    public function create()
    {
        $users =  User::all();
        return view('posts.create', [
            'users' => $users,
        ]);
    }

    public function store()
    {
        $req = request()->all();
        Post::create([
            'title' =>  $req['title'],
            'description' =>  $req['description'],
            'user_id' => $req['post_creator'],
        ]);
        return redirect()->route('posts.index')->with('success', "post created");
        //return to_route('posts.index');
    }

    public function show($postId)
    {
        $post=post::find($postId);
        return view("posts.show",["post"=>$post]);
    }

    public function edit($postId)
    {
        $users = User::all();
        $post = Post::find($postId);
        return view('posts.edit', [
            'post' => $post,
            'users' => $users,
        ]);
    }

    public function update()
    {
        $req=request()->all();
        post::where('id',$req['id'])->update([
            'title'=>$req['title'],
            'description'=>$req['description'],
            'user_id'=>$req['creator']
        ]);
       return to_route('posts.index');
    }

    public function delete($postId)
    {
        post::where('id',$postId)->delete();
        return to_route('posts.index');
    }
}
