const gulp = require('gulp');
const sass = require('gulp-sass');
const autoprefixer = require('gulp-autoprefixer');
const watch = require('gulp-watch');
const babel = require('gulp-babel');
const browserify = require('browserify');
const browserSync = require('browser-sync').create();

// Variables
let input = './src/sass/*.scss';
const output = './src/css';
const sassOptions = {
  errLogToConsole: true,
  outputStyle: 'expanded'
};

// process JS files and return the stream.
gulp.task('js', function () {
	return gulp.src('js/*js')
		.pipe(gulp.dest('./dist'));
});

// create a task that ensures the `js` task is complete before
// reloading browsers
gulp.task('js-watch', ['js'], function (done) {
	browserSync.reload();
	done();
});

// Compile sass into CSS & auto-inject into browsers
gulp.task('sass', function() {
	return gulp.src(input)
		.pipe(sass(sassOptions).on('error', sass.logError))
		.pipe(autoprefixer())
		.pipe(gulp.dest(output))
		.pipe(browserSync.stream());
});

// Static Server + watching scss/html files
gulp.task('serve', ['sass'], function() {
	browserSync.init({
		server: "./"
	});
	gulp.watch(input, ['sass']);
	gulp.watch("./src/*.html").on('change', browserSync.reload);
	gulp.watch("./src/js/*.js", ['js-watch']);
});

gulp.task('default', ['serve']);
