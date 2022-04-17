

<?php $__env->startSection('title'); ?>Create <?php $__env->stopSection(); ?>

<?php $__env->startSection('content'); ?>
<form method="POST" action="<?php echo e(route('posts.store')); ?>">
    <?php echo csrf_field(); ?>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Title</label>
        <input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
        <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>

    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Post Creator</label>
        <select name="creator" class="form-control">
            <option value="Ahmed">Ahmed</option>
            <option value="Mohamed">Mohamed</option>
            <option value="Mahmoud">Mahmoud</option>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Create</button>
</form>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('layouts.app', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH D:\laravel\iti\resources\views/posts/create.blade.php ENDPATH**/ ?>