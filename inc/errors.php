
<?php  
if (!empty($errors) && count($errors) > 0) : ?>
  <div class="error">
  	<?php foreach ($errors as $error) : ?>
  	  <p class="errori"><?php echo $error ?></p>
  	<?php endforeach ?>
  </div>
<?php  endif ?>