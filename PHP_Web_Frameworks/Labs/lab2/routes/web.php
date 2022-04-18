<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PostController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('Welcome');
// });

Route::get('/', [PostController::class, 'index'])->name('posts.index');

Route::get('/posts', [PostController::class, 'index'])->name('posts.index');
Route::get('/posts/create/', [PostController::class, 'create'])->name('posts.create');
Route::post('/posts', [PostController::class, 'store'])->name('posts.store');
Route::post('/posts/edit', [PostController::class, 'update'])->name('posts.update');
Route::get('/posts/edit/{post}', [PostController::class, 'edit'])->name('posts.edit');
Route::get('/posts/view/{post}', [PostController::class, 'show'])->name('posts.view');
Route::get('/posts/delete/{post}', [PostController::class, 'delete'])->name('posts.delete');
