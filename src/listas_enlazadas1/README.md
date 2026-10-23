# TAD Lista: estática vs. dinámica

`ListaEstatica` conviene cuando se conoce de antemano la cantidad máxima de elementos y se necesita acceder por índice en O(1), ya que los datos están contiguos en un arreglo.
Su costo aparece al insertar o eliminar en el medio, porque hay que desplazar elementos, y en la capacidad fija, que no puede crecer.
`ListaEnlazada` conviene cuando la cantidad de elementos es variable o hay muchas inserciones y eliminaciones: crece nodo a nodo y borrar sólo implica reenganchar un puntero.
A cambio, buscar o llegar a una posición siempre exige recorrer desde la cabeza, O(n), y cada nodo ocupa memoria extra por la referencia al siguiente.
