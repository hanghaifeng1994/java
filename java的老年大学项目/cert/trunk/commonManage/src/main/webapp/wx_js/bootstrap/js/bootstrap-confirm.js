/* ========================================================================
 * Bootstrap: confirm.js v3.0.3 by hbqian
 * http://getbootstrap.com/javascript/#modals
 * ========================================================================
 * Copyright 2013 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ======================================================================== */
(function ($) {
    $.fn.showModal = function (content, callback) {
        var HTML = '<div class="modal fade generic-modal">' +
            '  <div class="modal-dialog">' +
            '    <div class="modal-content">' +
            '        <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="margin-right: 10px;margin-top: 5px;">&times;</button>' +
            '      <div class="modal-body">' + content +
            '      </div>' +
            '      <div class="modal-footer">' +
            '        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>' +
            '        <button type="button" class="btn btn-primary ok-button-dialog">确定</button>' +
            '      </div>' +
            '   </div><!-- /.modal-content -->' +
            '  </div><!-- /.modal-dialog -->' +
            '</div><!-- /.modal -->';

        var container = $('<div></div>').html(HTML);
        var newInstance = jQuery.extend(true, {}, container);
        newInstance.find('.ok-button-dialog').bind('click', function () {
            callback();
        });
        var modalElement = newInstance.find('.generic-modal');
        modalElement.modal();
        return modalElement;
    }
    
    $.fn.showAlert = function (content,callback) {
        var HTML = '<div class="modal fade generic-modal">' +
            '  <div class="modal-dialog">' +
            '    <div class="modal-content">' +
            '        <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="margin-right: 10px;margin-top: 5px;">&times;</button>' +
            '      <div class="modal-body">' + content +
            '      </div>' +
            '      <div class="modal-footer">' +
            '        <button type="button" class="btn btn-primary ok-button-dialog">确定</button>' +
            '      </div>' +
            '   </div><!-- /.modal-content -->' +
            '  </div><!-- /.modal-dialog -->' +
            '</div><!-- /.modal -->';

        var container = $('<div></div>').html(HTML);
        var newInstance = jQuery.extend(true, {}, container);
        newInstance.find('.ok-button-dialog').bind('click', function () {
            callback();
        });
        var modalElement = newInstance.find('.generic-modal');
        modalElement.modal();
        return modalElement;
    }
}(jQuery));

function b_confirm (message,callback) {
    var modal = $(this).showModal(message, function() {
        modal.modal('hide');
    	callback();
    });
 }

function b_alert(message) {
    var modal = $(this).showAlert(message, function() {
    	modal.modal('hide');
    	//callback();
    });
 }