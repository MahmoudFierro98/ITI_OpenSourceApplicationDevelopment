

<?php $__env->startSection('title'); ?>View <?php $__env->stopSection(); ?>

<?php $__env->startSection('content'); ?>
<form>
    <input type="HIDDEN" name="id" value=<?php echo e($post['id']); ?> class="form-control" id="exampleFormControlInput1" disabled>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Title</label>
        <input type="text" name="title" value=<?php echo e($post['title']); ?> class="form-control" id="exampleFormControlInput1" disabled>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
        <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3" disabled><?php echo e($post['description']); ?></textarea>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Post Creator</label>
        <input type="text" name="creator" value=<?php echo e($post['post_creator']); ?> class="form-control" disabled>
    </div>
</form>
<?php $__env->stopSection(); ?>

<!-- 
<?php $__env->startSection('content'); ?>
<div class=" container border border-dark rounded my-5 ">
    <div class="mx-5">
        <p class="fw-bold">post Creator Info</p>
        <hr>
        <p>Id: <span> <?php echo e($post['id']); ?> </span>
        <p>
        <p>Name: <span> <?php echo e($post['post_creator']); ?></span>
        <p>
        <p>title: <span> <?php echo e($post['title']); ?> </span> </p>
        <p>created_at: <span> <?php echo e($post['created_at']); ?></span>
    </div>
</div>
<?php $__env->stopSection(); ?> -->
<?php echo $__env->make('layouts.app', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH D:\laravel\iti\resources\views/posts/show.blade.php ENDPATH**/ ?>