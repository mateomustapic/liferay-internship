var gulp = require('gulp');
var sass = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
var watch = require('gulp-watch');
var webserver = require('gulp-webserver');

// Variables
var input = 'sass/*.scss';
var output = '././css';
var sassOptions = {
  errLogToConsole: true,
  outputStyle: 'expanded'
};

// Sass compiler
gulp.task('sass', function() {
  return gulp
    .src(input)
    .pipe(sass(sassOptions).on('error', sass.logError))
    .pipe(autoprefixer())
    .pipe(gulp.dest(output));
});

// Gulp server
gulp.task('webserver', function() {
  gulp.src('./')
    .pipe(webserver({
      livereload: true,
      directoryListing: true,
      open: true,
      fallback: 'index.html'
    }));
});


// Watch task
gulp.task('watch', function() {
  return gulp
    .watch(input, ['sass']);
});


gulp.task('default', ['sass', 'watch', 'webserver']);
