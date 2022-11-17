using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.CompilerServices;

namespace _10_Ejercicio1.ViewModels.Utilidades
{
        public abstract class clsVMBase : INotifyPropertyChanged
        {
            public event PropertyChangedEventHandler PropertyChanged;
            
                                        //CallerMemberName es para que me pille el nombre del bindeo que lo llama del tirón sin tener que sarselo.
            protected virtual void NotifyPropertyChanged([CallerMemberName] string propertyName = null)
            {
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
            }
        }
}