<!-- ======== Début Code HTML ======== -->

<div class="row">
    <div class="col-lg-offset-3 col-lg-6 site-wrapper">
        <div class="row">
            <form action="connexion" method="post" name="login" accept-charset="utf-8">
                <fieldset>
                    <legend>Connexion à Sushinos</legend>
                    <input type="hidden" name="page" value="connexion"/>
                    <div class="row">
                        <div class="form-group has-error">
                            <c:if test="${!empty requestScope.message}">
                                <span class='help-block'>${requestScope.message}</span>
                            </c:if>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-offset-4 col-lg-4">
                            <div class="form-group">
                                <label for="pseudo" class="control-label">Pseudo ou Adresse e-mail</label>
                                <input type="text" id="pseudo" name="pseudo" placeholder="Pseudo ou Adresse e-mail" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-offset-4 col-lg-4">
                            <div class="form-group">
                                <label for="mdp" class="control-label">Mot de passe</label>
                                <input type="password" id="mdp" name="mdp" placeholder="Mot de passe" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-offset-4 col-lg-4">
                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn btn-success">Connexion</button>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="row">
            <p class="lead">Pas encore inscrit ? <a href="inscription" class="text-info">Inscrivez-vous par ici</a> !</p>
        </div>
    </div>
</div>

<!-- ======== Fin Code HTML ======== -->