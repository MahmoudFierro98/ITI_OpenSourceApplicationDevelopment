

<?php $__env->startSection('title'); ?>Edit <?php $__env->stopSection(); ?>

<?php $__env->startSection('content'); ?>
<form method="POST" action="<?php echo e(route('posts.update')); ?>">
    <?php echo csrf_field(); ?>
    <input type="hidden" name="id" value=<?php echo e($post['id']); ?> class="form-control" id="exampleFormControlInput1">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Title</label>
        <input type="text" name="title" value=<?php echo e($post['title']); ?> class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
        <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"><?php echo e($post['description']); ?></textarea>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Post Creator</label>
        <select name="creator" value=<?php echo e($post['post_creator']); ?> class="form-control">
            <option value="<?php echo e($post['post_creator']); ?>" selected hidden><?php echo e($post['post_creator']); ?></option>
            <option value="Ahmed">Ahmed</option>
            <option value="Mohamed">Mohamed</option>
            <option value="Mahmoud">Mahmoud</option>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('layouts.app', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH D:\laravel\iti\resources\views/posts/edit.blade.php ENDPATH**/ ?>