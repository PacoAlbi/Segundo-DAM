Imports System.Windows.Forms.VisualStyles.VisualStyleElement
Imports _03_Hello_World_Entidades_Estandar

Public Class Form1
    ''' <summary>
    ''' prototipo: Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
    ''' comentarios: Evento asociado al botón click saludar. Mostrará por pantalla el nombre de la persona escrito en una ventana a parte.
    ''' precondiones: No tiene.
    ''' </summary>
    ''' <param name="sender"></param>
    ''' <param name="e"></param
    ''' postcondiciones: No devuelve nada ya que es un evento.

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        'Declaración de variable
        Dim usuario = New clsPersona
        usuario.Nombre = TextBox1.Text
        Dim texto As String

        'Comprobación del nombre
        If usuario.Nombre = "" Or usuario.Nombre.StartsWith(" ") Then texto = "Debe introducir un nombre" Else texto = "Hola " + usuario.Nombre
        MessageBox.Show(texto)

        'La forma de hacer la alerta en rojo.
        'If usuario.Nombre.Length = 0 Then
        'lblError.Visible = True
        'Else
        'lblError.Visible = False
        'usuario = New clsPersona(txtNombre.Text)
        'MessageBox.Show("Hola " + usuario.Nombre)
        'End If

    End Sub
End Class