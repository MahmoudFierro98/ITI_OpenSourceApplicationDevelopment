<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Comment;

class CommentController extends Controller
{
    public function store(Request $request)
    {
        $request->validate([
            'user_id' => 'required|exists:users,id',
            'body' => 'required|string',
            'commentable_id' => 'required|integer',
            'commentable_type' => 'required|string',
        ]);

        Comment::create([
            'user_id' => $request->user_id,
            'body' => $request->body,
            'commentable_id' => $request->commentable_id,
            'commentable_type' => $request->commentable_type,
        ]);
        
        return back();
    }
}
