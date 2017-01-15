<%-- 
    Document   : carte
    Created on : 7 janv. 2017, 18:19:08
    Author     : Pierre-Elliott
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- ======== Début Code HTML ======== -->

<!-- Popup d'information succès ajout produit -->
<div class="alert alert-success hidden">
    Produit correctement ajouté !
</div>
<!-- fin popup -->

<div class="row">
    <div class="col-lg-offset-3 col-lg-6 site-wrapper">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#produits" data-toggle="tab">Nos produits</a></li>
            <!--<li><a href="#menus" data-toggle="tab">Nos menus</a></li>-->
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="produits">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Produit</th>
                            <th>Description</th>
                            <th>Image</th>
                            <th>Ajout panier</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.carte.produits}" var="produit">
                        <tr class="text-muted">
                            <td>
                                <a href="#produitModal" data-toggle="modal"
                                   data-numProduit="${produit.numProduit}"
                                   data-libelle="${produit.libelle}"
                                   data-sourceImg="${produit.image}"
                                   data-description="${produit.description}"
                                   data-prix="${produit.prix}">
                                    ${produit.libelle}
                                </a>
                            </td>
                            <td>${produit.description}</td>
                            <td><img src="${produit.image}" alt='Image du produit'></td>
                            <td>
                                <a  href="panier?action=ajout&numProduit=${produit.numProduit}&qte=1" type="button" data-action="ajout" data-produit="${produit.numProduit}" class="btn btn-primary">
                                        <img title='Ajouter au panier' alt='Ajouter au panier' src='images/achat2.png'>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="modal fade" id="produitModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                                <h4 class="modal-title text-muted"></h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <img src="images/sushi.png" alt="Image du produit" id="imgModal" class="img-responsive text-muted">
                                    </div>
                                    <div class="col-xs-8">
                                        <p class="text-muted" id="descriptionProduit"></p>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <p id="prixProduit" class="text-center text-muted"></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- ======== Fin Code HTML ======== -->

<!-- ======== Début Code Javascript ======== -->
<script>
    $(function ()
    {


        $('button').click(function (e) {
            var produit = $(this).data('produit');
            var action = $(this).data('action');
            //var qte = $(this).data('qte');
            console.log(produit);
            console.log(action);
            //console.log(qte);
            $.post('WEB-INF/panier',
            {
                action: action,
                numProduit: produit
                //qte: qte
            },
            function (data, status)
            {
                // Faire une popup pour indiquer que le produit à bien été ajouté
                var fenAlert = $('.alert');
                fenAlert.removeClass('hidden');
                setTimeout(function ()
                {
                    fenAlert.addClass('hidden');
                }, 2500);
            });
        });

        $('#produitModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget);
            var numProduit = button.data('numProduit');
            var libelle = button.data('libelle');
            var sourceImg = button.data('sourceImg');
            var description = button.data('description');
            var prix = button.data('prix');
            var modal = $(this);
            modal.find('.modal-title').text(libelle);
            modal.find('#imgModal').attr('src', sourceImg);
            modal.find('#descriptionProduit').text(description);
            modal.find('#prixProduit').text('Prix : ' + prix + '€');
        });
    });
</script>
<!-- ======== Fin Code Javascript ======== -->
