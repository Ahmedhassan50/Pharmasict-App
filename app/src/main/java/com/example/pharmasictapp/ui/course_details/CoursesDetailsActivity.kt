package com.example.pharmasictapp.ui.course_details

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.db.model.Instructor

class CoursesDetailsActivity : AppCompatActivity() {
    lateinit var lessons_recycle_view:RecyclerView
    lateinit var instructors_recycle_view:RecyclerView
    lateinit var tvCourseName:TextView
    lateinit var tvCourseObjective:TextView
    lateinit var tvCourseType:TextView
    lateinit var btnEnrollToCourse:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_details)
        initCourseDetails()
        setLessonsData()
        setInstructorsData()
        setCourseData()

        val notificationIntent=intent
        if(notificationIntent!=null)
        { val  msg=notificationIntent.getStringExtra("msg")
        val title=notificationIntent.getStringExtra("title")
            if (title != null) {
                if(title.isEmpty())
                    tvCourseName.text=title
            }
        }

        btnEnrollToCourse.setOnClickListener{

            var dialog=RegisterDialog()
            val args = Bundle()
            args.putString("name", tvCourseName.text.toString())
            args.putString("type", tvCourseType.text.toString())
            dialog.arguments=args
            dialog.show(supportFragmentManager,"Confirm")




        }


    }

    private fun setCourseData() {
        val course:Course= Course()
        tvCourseName.text=course.getName()
        tvCourseType.text=course.getType()
        tvCourseObjective.text=course.getObjective()
    }

    private fun initCourseDetails(){
        btnEnrollToCourse=findViewById(R.id.btn_course_details_enroll)
        lessons_recycle_view=findViewById(R.id.course_details_lessons_recycle_view)
        lessons_recycle_view.layoutManager= LinearLayoutManager(this)
        lessons_recycle_view.setHasFixedSize(true)

        instructors_recycle_view=findViewById(R.id.course_details_instructors_recycle_view)
        instructors_recycle_view.layoutManager= LinearLayoutManager(this)
        instructors_recycle_view.setHasFixedSize(true)


        tvCourseName=findViewById(R.id.tv_course_details_name)
        tvCourseObjective=findViewById(R.id.tv_course_details_objective)
        tvCourseType=findViewById(R.id.tv_course_details_type)




    }

    private fun setLessonsData(){
     val lessons= arrayListOf<String>()
        // get data from DB, then lessons == data
        lessons.add("introductions")
        lessons.add("Arrays")
        lessons.add("Variables")
        lessons.add("sets")
        lessons.add("lists")
        lessons_recycle_view.adapter=LessonAdaptor(lessons)

    }
    private fun setInstructorsData(){
        val instructors= arrayListOf<Instructor>()
        // get data from DB, then instructors == data
        val instructor=Instructor()
        instructor.setName("Nouran Hussein")
        instructor.setDescription("Computer Engineer at Eva Pharma")
        instructors.add(instructor)
        val instructor2=Instructor()
        instructor.setName("Ahmed Sayed")
        instructor.setDescription("Computer Engineer at Eva Pharma")
        instructors.add(instructor2)
        val instructor3=Instructor()
        instructor.setName("Zaina Ayman")
        instructor.setDescription("Computer Engineer at Eva Pharma")
        instructors.add(instructor3)
        instructors_recycle_view.adapter=InstructorAdapter(instructors)

    }


}