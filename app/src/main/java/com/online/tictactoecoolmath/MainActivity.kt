package com.online.tictactoecoolmath

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{
    var total=0
    var numofgames=0
    var tied=0;
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Buttonclick(view: View)
    {
        val butselected: Button = view as Button
        var cellid=0

        when (butselected.id)
        {
            R.id.button1 -> cellid=1
            R.id.button2 -> cellid=2
            R.id.button3 -> cellid=3
            R.id.button4 -> cellid=4
            R.id.button5 -> cellid=5
            R.id.button6 -> cellid=6
            R.id.button7 -> cellid=7
            R.id.button8 -> cellid=8
            R.id.button9 -> cellid=9

        }
        Log.d("Clicked", butselected.id.toString())
        Log.d("Clicked", cellid.toString())

        playgame(cellid,butselected)

    }
    var activeplayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    @SuppressLint("ResourceAsColor")
    fun playgame(cellid:Int, butselected:Button)
    {
        if(activeplayer==1)
        {
            butselected.text="X"
            butselected.setBackgroundResource(R.color.colorred)
            player1.add(cellid)
            total=total+1
            activeplayer=2



        }
        else
        {
            butselected.text="O"
            butselected.setBackgroundResource(R.color.colorgreen)
            player2.add(cellid)
            total=total+1
            activeplayer=1
        }
        butselected.isEnabled=false
       callingwinner()
    }


    private fun callingwinner()

    {
        var winnerr= -1

        if(player1.contains(1)&& player1.contains(2) && player1.contains(3))
        {
            winnerr=1

        }
        if(player2.contains(1)&& player2.contains(2) && player2.contains(3))
        {
            winnerr=2

        }
        if(player1.contains(5)&& player1.contains(4) && player1.contains(6))
        {
            winnerr=1
        }
        if(player2.contains(4)&& player2.contains(5) && player2.contains(6))
        {
            winnerr=2
        }
        if(player1.contains(7)&& player1.contains(8) && player1.contains(9))
        {
            winnerr=1
        }
        if(player2.contains(7)&& player2.contains(8) && player2.contains(9))
        {
            winnerr=2
        }




        if(player1.contains(1)&& player1.contains(4) && player1.contains(7))
        {
            winnerr=1

        }
        if(player2.contains(1)&& player2.contains(4) && player2.contains(7))
        {
            winnerr=2

        }
        if(player1.contains(2)&& player1.contains(5) && player1.contains(8))
        {
            winnerr=1

        }
        if(player2.contains(2)&& player2.contains(5) && player2.contains(8))
        {
            winnerr=2
        }
        if(player1.contains(3)&& player1.contains(6) && player1.contains(9))
        {
            winnerr=1
        }
        if(player2.contains(3)&& player2.contains(6) && player2.contains(9))
        {
            winnerr=2
        }

        if(winnerr==1)
        {
            p1wincount=p1wincount+1
            numofgames=numofgames+1
            total=0
            player1score.text="Player 1's Score: $p1wincount"
            player2score.text="Player 2's Score: $p2wincount"
            totalgames.text="Total number of Games: $numofgames"
            drawmatches.text="Number of matces Tied: $tied  "
         Toast.makeText(this, "Player 1 Won the match", Toast.LENGTH_LONG).show()
         restartagain()
        }
        else if(winnerr==2)
        {
            p2wincount=p2wincount+1
            numofgames=numofgames+1
            total=0
            player1score.text="Player 1's Score: $p1wincount"
            player2score.text="Player 2's Score: $p2wincount"
            totalgames.text="Total number of Games: $numofgames"
            drawmatches.text="Number of matces Tied: $tied  "

            Toast.makeText(this, "Player 2 Won the match", Toast.LENGTH_LONG).show()
          restartagain()

        }
        else if(total==9)
        {
            numofgames=numofgames+1
            tied=tied+1
            player1score.text="Player 1's Score: $p1wincount"
            player2score.text="Player 2's Score: $p2wincount"
            totalgames.text="Total number of Games: $numofgames"
            drawmatches.text="Number of matces Tied: $tied  "
            Toast.makeText(this, "Game over", Toast.LENGTH_LONG).show()
           restartagain()

        }




    }
    var p1wincount =0
    var p2wincount =0

    fun restartagain()
    {
        activeplayer=1
        player1.clear()
        player2.clear()

        for (cellid in 1..9)
        {
            var butselected:Button? = when (cellid)
            {
                1->button1
                2->button2
                3->button3
                4->button4
                5->button5
                6->button6
                7->button7
                8->button8
                9->button9
                else->{button1}
            }

            butselected!!.text=""
            butselected!!.setBackgroundResource(R.color.colourdefault)
            butselected!!.isEnabled=true


        }


     //   Toast.makeText(this, "Player 1: $p1wincount, Player 2: $p2wincount",Toast.LENGTH_LONG).show()




    }


}
