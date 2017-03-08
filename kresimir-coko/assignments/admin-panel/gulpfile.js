const gulp = require('gulp');
const sass = require('gulp-sass');
const autoprefixer = require('gulp-autoprefixer');
const watch = require('gulp-watch');
const webserver = require('gulp-webserver');
const babel = require('gulp-babel');

// Variables
let input = './src/sass/*.scss';
const output = './src/css';
const sassOptions = {
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

// ES6 compiler
gulp.task('es6', () => {
  return gulp.src('src/js/*.js')
    .pipe(babel({
      presets: ['es2015']
    }))
    .pipe(gulp.dest('dist'));
});

// Gulp server
gulp.task('webserver', function() {
  gulp.src('./')
    .pipe(webserver({
      livereload: true,
      directoryListing: true,
      open: false,
      fallback: 'index.html'
    }));
});

// Watch task
gulp.task('watch', function() {
  return gulp
    .watch(input, ['sass']);
});

gulp.task('default', ['sass', 'es6', 'watch', 'webserver']);
